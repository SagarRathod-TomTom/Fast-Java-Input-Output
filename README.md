### Fast-Java-Input-Output
An ultra fast way for reading/writing data from I/O stream.

Most Java programmers need a fast way to read the data from input stream as well as to write the data to output stream in order to compete in programming challenges on Hackerrank and Hackerearth.
  
- Below is the performance measures for the same problem [**BinaryQueries**](https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/range-query-2/) solved using:
 
  1. **java.util.Scanner** for reading the data and **System.out.println** for writing the data, which has taken total **26.3188 sec**.
  
      ![Image](/../master/Fast%20Java%20IO/resources/Scanner%20Input%20and%20%20SOP.png?raw=true)
  
  2. **BufferInput.java** for reading the data and **System.out.println** for writing the data, which has taken total **10.86089 sec**.
  
     ![Image](/../master/Fast%20Java%20IO/resources/Buffer%20Input%20and%20SOP.png?raw=true)
  
  3. **BufferInput.java** for reading the data and **BufferOutput.java** for writing the data, which has taken total **1.51384 sec**, and      it beats the above two timings.
  
     ![Image](/../master/Fast%20Java%20IO/resources/Buffer%20Input%20and%20Outputpng.png?raw=true)


### Code Sample

```
import java.io.IOException;
import com.sagarrathod.fastio.BufferInput;
import com.sagarrathod.fastio.BufferOutput;

public class TestClass {
  public static void main(String[] args) throws IOException {
    BufferInput bufferInput = new BufferInput();
    BufferOutput bufferOutput = new BufferOutput();
    
    bufferOutput.writeString(Double.toString(bufferInput.nextInt() * 10.4));
    // necessary to ensure all buffered contents are written
    bufferOutput.flush();
  }
}
```