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
package cn.fanhub.lova.stream;

import cn.fanhub.lova.stream.support.ProgressListener;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 课统计进度的 InputStream
 *
 * 最佳实践: httpclient 获取下载进度
 *
 * @author chengfan
 * @version $Id: CountingInputStream.java, v 0.1 2018年05月03日 下午9:40 chengfan Exp $
 */
public class CountingInputStream extends FilterInputStream {

    private final ProgressListener listener;
    private       long             transferred;

    CountingInputStream(final InputStream in, final ProgressListener listener) {
        super(in);
        this.listener = listener;
        this.transferred = 0;
    }
    /**
     * Read int.
     *
     * @return the int
     * @throws IOException the io exception
     */
    @Override
    public int read() throws IOException {
        int read = in.read();
        readCount(read);
        return read;
    }

    /**
     * Read int.
     *
     * @param buffer the buffer
     * @return the int
     * @throws IOException the io exception
     */
    @Override
    public int read(byte[] buffer) throws IOException {
        int read = in.read(buffer);
        readCount(read);
        return read;
    }

    /**
     * Read int.
     *
     * @param buffer the buffer
     * @param byteOffset the byte offset
     * @param byteCount the byte count
     * @return the int
     * @throws IOException the io exception
     */
    @Override
    public int read(byte[] buffer, int byteOffset, int byteCount)
            throws IOException {
        int read = in.read(buffer, byteOffset, byteCount);
        readCount(read);
        return read;
    }

    /**
     * Skip long.
     *
     * @param byteCount the byte count
     * @return the long
     * @throws IOException the io exception
     */
    @Override
    public long skip(long byteCount) throws IOException {
        long skip = in.skip(byteCount);
        readCount(skip);
        return skip;
    }

    private void readCount(long read) {
        if (read > 0) {
            this.transferred += read;
            this.listener.transfer(this.transferred);
        }
    }
}