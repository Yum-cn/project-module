/*
 * Copyright (C) 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.project.system.license;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Decebal Suiu
 */
public class IoUtils {

    public static byte[] getBytesFromFile(String file) throws IOException {
        return getBytes(new FileInputStream(file));
    }

    public static byte[] getBytesFromResource(String resource) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        byte[] bytes = getBytes(classLoader.getResourceAsStream(resource));

        return bytes;
    }

    public static void writeFile(String file, byte[] bytes) throws IOException {
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(file);
            output.write(bytes);
        } finally {
            IoUtils.close(output);
        }
    }

    public static byte[] getBytes(InputStream input) throws IOException {
        ByteArrayOutputStream output = null;
        try {
            output = new ByteArrayOutputStream();

            byte buffer[] = new byte[1024];
            int length;
            while ((length = input.read(buffer)) >= 0) {
                output.write(buffer, 0, length);
            }

            return output.toByteArray();
        } finally {
            IoUtils.close(output);
            IoUtils.close(input);
        }
    }

    /**
     * Silently closes a Closeable.
     *
     * @return the exception or null if no exception thrown
     */
    public static IOException close(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
            return e;
        }

        return null;
    }

}
