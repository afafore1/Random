import java.math.BigInteger;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Checksum extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1491095631365917818L;
	static BigInteger s;
	static BigInteger d;
	private JLabel slabel;
	private JLabel dlabel;
	
	public Checksum(){
		super("Do checkSum");
		this.setSize(350, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
	}
	
	public void addButtons(){
		slabel = new JLabel(String.valueOf(s));
		dlabel = new JLabel(String.valueOf(d));
		slabel.setSize(200, 30);
		dlabel.setSize(200, 30);
		slabel.setLocation(10, 50);
		dlabel.setLocation(10, 60);
		this.getContentPane().add(slabel);
		this.getContentPane().add(dlabel);
	}
	static int makeBit(){
		Random random = new Random();
		int bit = random.nextInt(65535 - 32769 + 1) + 32769;
		return bit;
	}

	static String doCheckSum(){
		String checkSum;
		checkSum = s.add(d).toString(2);
		return checkSum;
	}
	public static void main(String[] args) { 
		int first = makeBit();
		int second = makeBit();
		s = new BigInteger(Integer.toBinaryString(first),2);
		d = new BigInteger(Integer.toBinaryString(second),2);
		String solution = doCheckSum();
		
		System.out.println(" "+Integer.toBinaryString(first)+"\n "+Integer.toBinaryString(second)+"\n-----------------\n"+solution);
		Checksum cs = new Checksum();
		cs.addButtons();
		cs.setVisible(true);
		ClassLoader loader = Checksum.class.getClassLoader();
		System.out.println(loader.getResource("Checksum.class"));
	}

}
