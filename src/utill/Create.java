package utill;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;
//入力を自動化してみた
public class Create {

	public static InputStream run() {
		Random rnd = new Random();
		System.out.println("10000");

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10000; i++) {
			sb.append(rnd.nextInt(9000));
			sb.append(" ");
		}
		//System.out.print(sb);

		InputStream inputStream = new ByteArrayInputStream(sb.toString().getBytes(StandardCharsets.UTF_8));
		return inputStream;
	}
}
