package com.sagarrathod.fastio;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * BufferOutput lets you buffer the output contents in memory, once it becomes full,
 * it automatically flushes the output content to the output stream.
 * 
 * @author Sagar Rathod
 * @version 1.0
 *
 */
public class BufferOutput {

	private DataOutputStream dout;
	
	/**
	 *  A constant holding default buffer size, 2<sup>16</sup> bytes of memory.
	 * 
	 **/
	final private int BUFFER_SIZE = 1 << 16;

	
	private byte[] buffer;
	
	/**
	 * The current position in the buffer for next byte to be written.
	 */
	private int pointer = 0;
		
	/**
	 * Creates an instance of {@link BufferOutput} with {@link DataOutputStream}
	 * linked to the console output stream.
	 */
	public BufferOutput() {
		buffer = new byte[BUFFER_SIZE];
		dout = new DataOutputStream(System.out);
	}

	/**
	 * Creates an instance of {@link BufferOutput} with {@link DataOutputStream}
	 * linked to the {@link OutputStream} specified by the out.
	 */
	public BufferOutput(OutputStream out) {
			
		buffer = new byte[BUFFER_SIZE];
		dout = new DataOutputStream(out);
	}

	/**
	 * Writes the array of bytes to the buffer.
	 * 
	 * If buffer doesn't have enough space to accommodate the array, 
	 * the contents of buffer are written to the output stream.
	 * 
	 * @param arr
	 * @throws IOException
	 */
	public void writeBytes(byte arr[]) throws IOException {

		int bytesToWrite = arr.length;

		if (pointer + bytesToWrite >= BUFFER_SIZE) {
			flush();
		}

		for (int i = 0; i < bytesToWrite; i++) {
			buffer[pointer++] = arr[i];
		}
	}

	/**
	 * Writes the string as array of bytes to the buffer.
	 * 
	 * @param str
	 * @throws IOException
	 */
	public void writeString(String str) throws IOException {
		writeBytes(str.getBytes());
	}

	/**
	 * Writes the contents of full buffer to the output stream.
	 * 
	 * @throws IOException
	 */
	private void flush() throws IOException {
		dout.write(buffer, 0, pointer);
		dout.flush();
		pointer = 0;
	}

	public void close() throws IOException{
		dout.close();
	}
}
