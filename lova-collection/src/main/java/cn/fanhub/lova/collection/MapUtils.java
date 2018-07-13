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
package cn.fanhub.lova.collection;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author chengfan
 * @version $Id: MapUtils.java, v 0.1 2018年06月01日 下午7:41 chengfan Exp $
 */
public class MapUtils {

    public static <K, V> Map<K, V> sortByValue(Map<K, V> map) {
        Object parse = JSON.parse("{}");

        String o = JSON.parseObject("{}", String.class);
        JSONObject jsonObject = JSONObject.parseObject("{'a', : 'b'}");
        jsonObject.get("a");
        jsonObject.getInteger("a");

        JSONArray array = JSONArray.parseArray("[{}]");
        JSONObject o1 = array.getJSONObject(0);
        o1.getDate("a");

        for (Object o2 : array) {
            JSONObject object = ((JSONObject) o2);

            for (Entry<String, Object> objectEntry : object.entrySet()) {
                String key = objectEntry.getKey();
            }
        }

        return map;
    }
}