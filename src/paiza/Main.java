package paiza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String halfwith = " ";

		//1行目の処理
		String line1 = sc.nextLine();
		//人数
		int num = Integer.parseInt(line1);

		//2行目の処理
		List<User> list = new ArrayList<>();

		for (int i = 0; i < num; i++) {
			String lineN = sc.nextLine();
			Main.User user = new Main().new User();
			int firstIndex = 0;
			int lastIndex = 0;
			String value = null;
			for (int j = 1; j <= 3; j++) {
				lastIndex = lineN.indexOf(halfwith, firstIndex);
				value = lineN.substring(firstIndex, lastIndex);
				switch (j) {
				case 1:
					user.setNickname(value);
					break;
				case 2:
					user.setOld(value);
					break;
				case 3:
					user.setBirth(value);
					continue;
				}
				firstIndex = lastIndex + 1;
			}
			firstIndex = lineN.lastIndexOf(halfwith) + 1;
			lastIndex = lineN.length();
			value = lineN.substring(firstIndex, lastIndex);
			user.setState(value);
			list.add(user);
		}

		Collections.sort(list, new Main().new UserComparator());
		for (int i = 0; i < num; i++) {
			Main.User user = list.get(i);
			StringBuilder str = new StringBuilder(user.getNickname());
			str.append(halfwith).append(user.getOld()).append(halfwith).append(user.getBirth()).append(halfwith)
					.append(user.getState());
			System.out.println(str);
		}
	}

	// 内部Bean
	public class User {
		private String nickname;
		private String old;
		private String birth;
		private String state;

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public String getOld() {
			return old;
		}

		public void setOld(String old) {
			this.old = old;
		}

		public String getBirth() {
			return birth;
		}

		public void setBirth(String birth) {
			this.birth = birth;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}
	}

	public class UserComparator implements Comparator<User> {

		@Override
		public int compare(User o1, User o2) {
			int i = Integer.parseInt(o1.getOld());
			int j = Integer.parseInt(o2.getOld());
			if (i < j) {
				return -1;
			}
			if (i > j) {
				return 1;
			}
			return 0;
		}

	}

}
