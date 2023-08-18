/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.aws2.timestream.query;

import org.apache.camel.BindToRegistry;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.aws2.timestream.Timestream2Constants;
import org.apache.camel.component.aws2.timestream.Timestream2Operations;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.services.timestreamquery.model.DescribeEndpointsRequest;
import software.amazon.awssdk.services.timestreamquery.model.DescribeEndpointsResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Timestream2QueryProducerTest extends CamelTestSupport {

    @BindToRegistry("awsTimestreamQueryClient")
    AmazonTimestreamQueryClientMock clientMock = new AmazonTimestreamQueryClientMock();

    @EndpointInject("mock:result")
    private MockEndpoint mock;

    @Test
    public void timestreamDescribeQueryEndpointsTest() throws Exception {

        mock.expectedMessageCount(1);
        Exchange exchange = template.request("direct:describeQueryEndpoints", new Processor() {
            @Override
            public void process(Exchange exchange) {
                exchange.getIn().setHeader(Timestream2Constants.OPERATION, Timestream2Operations.describeEndpoints);
            }
        });

        MockEndpoint.assertIsSatisfied(context);

        DescribeEndpointsResponse resultGet = (DescribeEndpointsResponse) exchange.getIn().getBody();
        assertEquals(1, resultGet.endpoints().size());
        assertEquals("query.timestream.region.amazonaws.com", resultGet.endpoints().get(0).address());
    }

    @Test
    public void timestreamDescribeQueryEndpointsPojoTest() throws Exception {

        mock.expectedMessageCount(1);
        Exchange exchange = template.request("direct:describeQueryEndpointsPojo", new Processor() {
            @Override
            public void process(Exchange exchange) {
                exchange.getIn().setHeader(Timestream2Constants.OPERATION, Timestream2Operations.describeEndpoints);
                exchange.getIn().setBody(DescribeEndpointsRequest.builder().build());
            }
        });

        MockEndpoint.assertIsSatisfied(context);

        DescribeEndpointsResponse resultGet = (DescribeEndpointsResponse) exchange.getIn().getBody();
        assertEquals(1, resultGet.endpoints().size());
        assertEquals("query.timestream.region.amazonaws.com", resultGet.endpoints().get(0).address());
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from("direct:describeQueryEndpoints")
                        .to("aws2-timestream://query:test?awsTimestreamQueryClient=#awsTimestreamQueryClient&operation=describeEndpoints")
                        .to("mock:result");
                from("direct:describeQueryEndpointsPojo")
                        .to("aws2-timestream://query:test?awsTimestreamQueryClient=#awsTimestreamQueryClient&operation=describeEndpoints&pojoRequest=true")
                        .to("mock:result");

            }
        };
    }
}
