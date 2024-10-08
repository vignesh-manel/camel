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
package org.apache.camel.language.joor;

public class JoorCompilationException extends RuntimeException {

    private final String className;
    private final String code;

    public JoorCompilationException(String className, String code, Throwable cause) {
        super("jOOR compilation error for class: " + className, cause);
        this.className = className;
        this.code = code;
    }

    public String getClassName() {
        return className;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "\n\n" + codeWithLineNumbers() + "\n\n";
    }

    private String codeWithLineNumbers() {
        StringBuilder sb = new StringBuilder(256);
        String[] lines = code.split("\n");
        int counter = 0;
        for (String line : lines) {
            String s = String.format("%3d %s", ++counter, line);
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }

}
