package compiler;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Comp {

	public char ch;
	public int code;// 保留字状态码
	public static String[][] array = new String[100][2];
	public int i = 0;
	public StringBuffer strToken = new StringBuffer();// 存放构成单词符号的字符串

	public String[] retainWord = new String[] { "begin", "call", "do", "end", "const", "if", "odd", "procedure", "read",
			"write", "then", "while", "var" };// 保留字

	// 判断是否是字母
	public boolean IsLetter(char ch) {
		if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
			return true;
		}
		return false;
	}

	// 判断是否是数字
	public boolean IsDigit(char ch) {
		if (ch >= 48 && ch <= 57) {
			return true;
		}
		return false;
	}

	// 判断是否是edge
	public boolean IsEdge(char ch) {
		if ((ch >= 39 && ch <= 41) || ch == 46 || ch == 59) {
			return true;
		}
		return false;
	}

	// 判断是否是math
	public boolean IsMath(char ch) {
		if ((ch >= 60 && ch <= 62) || ch == 58 || ch == 47 || ch == 42 || ch == 43 || ch == 45) {
			return true;
		}
		return false;
	}

	// 判断是否是空格
	public boolean IsBC() {
		if (ch == 32 || ch == 13) {
			return true;
		}
		return false;
	}

	// 连接字符
	public void Concat(char ch) {
		strToken.append(ch);
	}

	// 判断是否是保留字
	public String Reserve() {
		for (int i = 0; i < retainWord.length; i++) {
			if (strToken.toString().equals(retainWord[i])) {
				return retainWord[i] + "sys";
			}
		}
		if (strToken.length() != 0) {
			if (strToken.charAt(0) >= '0' && strToken.charAt(0) <= '9') {
				return "ident";
			}
		}

		return "ident";
	}

	public void scanner() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("e:\\test1.txt"));
			while ((ch = (char) br.read()) != -1) {
				// System.out.println("======="+(char)ch);
				if (ch == '#')
					return;
				if (IsLetter((char) ch)) {
					Concat((char) ch); // no number in word
				} else if (IsDigit((char) ch)) {
					if (strToken.length() > 0) {

						if (strToken.charAt(0) == 60) {
							System.out.println("lss," + strToken);
							strToken.delete(0, strToken.length());
							Concat((char) ch);
						} else if (strToken.charAt(0) == 62) {
							System.out.println("gtr," + strToken);
							strToken.delete(0, strToken.length());
							Concat((char) ch);
						} else {
							Concat((char) ch);
						}

					} else
						Concat((char) ch);

				} else if (IsBC()) {
					if (strToken.length() > 0) {
						if (IsLetter(strToken.charAt(0))) {
							System.out.println(Reserve() + "," + strToken);
							array[i][0] = "number";
							array[i][1] = strToken.toString();
							i++;
						} else if (IsDigit(strToken.charAt(0))) {
							System.out.println("number," + strToken);
							array[i][0] = "number";
							array[i][1] = strToken.toString();
							i++;
						}
						strToken.delete(0, strToken.length());
					}
				} else if (IsMath((char) ch)) {
					if (ch == 43) {
						if (strToken.length() > 0) {
							System.out.println(Reserve() + "," + strToken);
							array[i][0] = "number";
							array[i][1] = strToken.toString();
							i++;
							strToken.delete(0, strToken.length());
						}
						System.out.println("plus," + (char) ch);
						array[i][0] = "plus";
						array[i][1] = "" + ch;
						i++;

					} else if (ch == 45) {
						if (strToken.length() > 0) {
							System.out.println(Reserve() + "," + strToken);
							array[i][0] = "number";
							array[i][1] = strToken.toString();
							i++;
							strToken.delete(0, strToken.length());
						}
						System.out.println("minus," + (char) ch);
						array[i][0] = "minus";
						array[i][1] = "" + ch;
						i++;

					} else if (ch == 42) {
						if (strToken.length() > 0) {
							System.out.println(Reserve() + "," + strToken);
							array[i][0] = "number";
							array[i][1] = strToken.toString();
							i++;
							strToken.delete(0, strToken.length());
						}
						System.out.println("times," + (char) ch);
						array[i][0] = "times";
						array[i][1] = "" + ch;
						i++;

					} else if (ch == 47) {
						System.out.println(Reserve() + "," + strToken);
						array[i][0] = "number";
						array[i][1] = strToken.toString();
						i++;
						System.out.println("slash," + (char) ch);
						array[i][0] = "slash";
						array[i][1] = "" + ch;
						i++;
						strToken.delete(0, strToken.length());
					} else if (ch == 61) {
						if (IsLetter(strToken.charAt(0))) {
							System.out.println(Reserve() + "," + strToken);
							array[i][0] = "number";
							array[i][1] = strToken.toString();
							i++;
							strToken.delete(0, strToken.length());
							System.out.println("equl," + (char) ch);
						} else if (strToken.charAt(0) == ':') {
							Concat((char) ch);
							System.out.println("becomes," + strToken);
							strToken.delete(0, strToken.length());
						} else if (strToken.charAt(0) == '>') {
							Concat((char) ch);
							System.out.println("geq," + strToken);
							strToken.delete(0, strToken.length());
						} else if (strToken.charAt(0) == '<') {
							Concat((char) ch);
							System.out.println("leq," + strToken);
							strToken.delete(0, strToken.length());
						}

					} else if (ch == 58) {
						System.out.println(Reserve() + "," + strToken);
						strToken.delete(0, strToken.length());
						Concat((char) ch);
					} else if (ch == 60) {
						if (IsLetter(strToken.charAt(0))) {
							System.out.println(Reserve() + "," + strToken);
							strToken.delete(0, strToken.length());
							Concat((char) ch);
						} else if (IsDigit(strToken.charAt(0))) {
							System.out.println("number," + strToken);
							strToken.delete(0, strToken.length());
							Concat((char) ch);
						}
					} else if (ch == 62) {
						if (IsLetter(strToken.charAt(0))) {
							System.out.println(Reserve() + "," + strToken);
							strToken.delete(0, strToken.length());
							Concat((char) ch);
						} else if (IsDigit(strToken.charAt(0))) {
							System.out.println("number," + strToken);
							strToken.delete(0, strToken.length());
							Concat((char) ch);
						} else {
							Concat((char) ch);
							System.out.println("neq," + strToken);
							strToken.delete(0, strToken.length());
						}
					}
				} else if (ch == 40) {
					if (strToken.length() > 0) {
						System.out.println(Reserve() + "," + strToken);
						array[i][0] = "number";
						array[i][1] = strToken.toString();
						i++;
						strToken.delete(0, strToken.length());
					}
					System.out.println("lparen," + (char) ch);
					array[i][0] = "lparen";
					array[i][1] = "" + ch;
					i++;
				} else if (ch == 41) {
					if (strToken.length() > 0) {
						System.out.println(Reserve() + "," + strToken);
						array[i][0] = "number";
						array[i][1] = strToken.toString();
						i++;
						strToken.delete(0, strToken.length());
					}
					System.out.println("rparen," + (char) ch);
					array[i][0] = "rparen";
					array[i][1] = "" + ch;
					i++;
				} else if (ch == 44) {
					System.out.println(Reserve() + "," + strToken);
					strToken.delete(0, strToken.length());
					System.out.println("comma," + (char) ch);
				} else if (ch == 59) {
					if (strToken.length() > 0) {
						if (IsLetter(strToken.charAt(0))) {
							System.out.println(Reserve() + "," + strToken);
							array[i][0] = "number";
							array[i][1] = strToken.toString();
							i++;
						} else if (IsDigit(strToken.charAt(0))) {
							System.out.println("number," + strToken);
							array[i][0] = "number";
							array[i][1] = strToken.toString();
							i++;
						}
						strToken.delete(0, strToken.length());
					}
					System.out.println("semicolon," + (char) ch);
					array[i][0] = "end";
					array[i][1] = ch + "";
					i++;

				} else if (ch == 46) {
					System.out.println(Reserve() + "," + strToken);
					strToken.delete(0, strToken.length());
					System.out.println("period," + (char) ch);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	String replace(String s0, String s, String m) {
		String ss = "";
		ss = s0.replace(s, m);

		return ss;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Comp c = new Comp();
		LinkedList<Integer> lList = new LinkedList<Integer>();
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请选择：0,exit；1，词法分析；2，语法分析");
			String result = scanner.next();
			switch (result) {
			default: {
				System.out.println("请选择：0,exit；1，词法分析；2，语法分析");
				break;
			}
			case "0": {
				System.exit(0);
			}
			case "1": {
				c.scanner();
				break;
			}
			case "2": {
				// lList=null;
				String s1 = "";
				System.out.println("语法分析:");
				for (int j = 0; j < 20; j++) {
					// System.out.println(array[j][0]);
					if (array[j][1] != null) {
						//System.out.println(array[j][0]);
						if (array[j][0].equals("number")) {
							s1 = s1 + 'T';
							// lList.addFirst(0);;
						} else if (array[j][0].equals("lparen")) {
							if (lList.isEmpty() || lList.getFirst() < 8) {
								lList.addFirst(1);
								s1 = s1 + '(';
							} else {
								if (s1.contains("T+T")) {
									s1 = c.replace(s1, "T+T", "T");
									lList.removeFirst();
									j--;
								} else if (s1.contains("(T)")) {
									s1 = c.replace(s1, "(T)", "T");
									lList.removeFirst();
									j--;
								} else {
									System.out.println("error0");
									return;
								}
							}
						} else if (array[j][0].equals("plus")) {
							// System.out.println(lList.getFirst());
							if (lList.isEmpty() || lList.getFirst() <= 1) {
								lList.addFirst(2);
								s1 = s1 + '+';
							} else {
								if (s1.contains("T+T")) {
									s1 = c.replace(s1, "T+T", "T");

									lList.removeFirst();
									j--;
								} else if (s1.contains("(T)")) {
									s1 = c.replace(s1, "(T)", "T");
									lList.removeFirst();
									--j;
								} else {
									System.out.println("error0");
									return;
								}
							}
						} else if (array[j][0].equals("rparen")) {
							if (lList.isEmpty() || lList.getFirst() <= 1) {
								lList.addFirst(8);
								s1 = s1 + ')';
							} else {
								if (s1.contains("T+T")) {
									s1 = c.replace(s1, "T+T", "T");
									lList.removeFirst();
									--j;
								} else if (s1.contains("(T)")) {
									s1 = c.replace(s1, "(T)", "T");
									lList.removeFirst();
									--j;
								} else {
									System.out.println("error1");
									return;
								}
							}
						} else if (array[j][0].equals("times")) {
							if (lList.isEmpty() || lList.getFirst() < 5) {
								lList.addFirst(6);
								s1 = s1 + '+';

							} else {
								if (s1.contains("T+T")) {
									s1 = c.replace(s1, "T+T", "T");
									lList.removeFirst();
									--j;
								} else if (s1.contains("(T)")) {
									s1 = c.replace(s1, "(T)", "T");
									lList.removeFirst();
									--j;
								} else {
									System.out.println("error2");
									return;
								}
							}
						} else if (array[j][0].equals("minus")) {
							if (lList.isEmpty() || lList.getFirst() < 3) {
								lList.addFirst(4);
								s1 = s1 + '+';
							} else {
								if (s1.contains("T+T")) {
									s1 = c.replace(s1, "T+T", "T");
									lList.removeFirst();
									--j;
								} else if (s1.contains("(T)")) {
									s1 = c.replace(s1, "(T)", "T");
									lList.removeFirst();
									--j;
								} else {
									System.out.println("error3");
									return;
								}
							}
						} else if (array[j][0].equals("end")) {
							if (s1.contains("T+T")) {
								s1 = c.replace(s1, "T+T", "T");
								lList.removeFirst();
								--j;
							} else if (s1.contains("(T)")) {
								s1 = c.replace(s1, "(T)", "T");
								lList.removeFirst();
								--j;
							} else if (s1.equals("T")) {
								System.out.println("success" + s1);
								return;
							} else {
								System.out.println("error4");
								return;
							}

						} else {

							System.out.println("error4");
							return;

						}
					}

				}
				System.out.println("error5");
				break;
			}
			}
		}
	}
}
