/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.util.servlet.filters;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;

/**
 * <a href="CacheResponseStream.java.html"><b><i>View Source</i></b></a>
 *
 * @author Alexander Chow
 */
public class CacheResponseStream extends ServletOutputStream {

	public CacheResponseStream(OutputStream os) {
		_os = os;
	}

	public void close() throws IOException {
		super.close();

		_closed = true;
	}

	public boolean isClosed() {
		return _closed;
	}

	public void write(int b) throws IOException {
		_os.write(b);
	}

	public void write(byte[] b) throws IOException {
		_os.write(b);
	}

	public void write(byte[] b, int off, int len) throws IOException {
		_os.write(b, off, len);
	}

	private boolean _closed;
	private OutputStream _os = null;

}