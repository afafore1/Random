
public class Concat {

	public static void main(String[] args) {
		char [] s = {'\\', '\t', '\r', '\b', '\f'};
		String out = "";
		for(int i = 0; i < s.length; i++)
		{
			char ch = s[i];
			if(ch == '\\')
			{
				out+= "\\\\";
			}
			out+= "\\"+ch;
			System.out.println(out +"blah"+ch);
		}
	}

}
