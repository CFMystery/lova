/**
 *    Copyright 2018 chengfan(fanhub.cn)
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
package cn.fanhub.lova.serializer;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * @author chengfan
 * @version $Id: HessionSerializerUtils.java, v 0.1 2018年07月13日 下午5:17 chengfan Exp $
 */
public class HessionSerializerUtils {

    public static byte[] serializer(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }

        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            HessianOutput ho = new HessianOutput(bo);
            ho.writeObject(o);
            byte[] bytes = bo.toByteArray();
            ho.close();
            bo.close();
            return bytes;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static <T> T deSerializer(byte[] data, Class<T> tClass) {
        return (T)deSerializer(data);
    }

    public static Object deSerializer(byte[] data) {
        if (data == null) {
            throw new NullPointerException();
        }
        try {
            ByteArrayInputStream bi = new ByteArrayInputStream(data);
            HessianInput hi = new HessianInput(bi);
            Object o = hi.readObject();
            hi.close();
            bi.close();
            return o;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}