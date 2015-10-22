import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.io.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ChartUtilities;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

@SuppressWarnings("serial")
public class Graph extends JPanel{
	// TODO Auto-generated method stub
	static int width = 1040;
	static int height = 780;
	static String elapsed = "ElapsedTime";
	static String peak = "Peak";
	static String Username = "";
	String version = "";
	JTextField username;
	JTextField OnepVersion;
	JButton submit;
	JLabel lblUsername;
	JLabel lblVersion;
	JRadioButton writeToExcel;
	
	public static String searchLast(String filename, String path){
		File folder = new File(path);
		File [] listFiles = folder.listFiles();
		Arrays.sort(listFiles);
		String file = null;
		for(int i = listFiles.length -1; i > 0; i--){
			if(listFiles[i].getName().startsWith(filename)){
				file = listFiles[i].getName();
				if(file.endsWith("log")){
					break;
				}				
			}
		}
		return file;

	}
	public static int searchTitle(String[] arr, String title){
		int indexpos = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i].equalsIgnoreCase(title)){
				indexpos = i;
			}
		}
		return indexpos;
	}
	
	public static String getDate(String s){
		return s.substring(s.indexOf(s.charAt(0)), s.indexOf(" "));
	}
	public static String removeNonTime(String n){
		return n.replaceFirst("20", "").replaceFirst("50", "").replaceFirst("11210", "");
	}
	public static String elapsedTime(String n){
		String rmove = removeNonTime(n);
		String eTime = rmove.substring(rmove.indexOf("0"), rmove.indexOf("."));
		eTime = eTime.replaceAll(":", ".");
		eTime = eTime.replaceFirst("[.]", "");
		return eTime;
	}
	public static String getElapsedLabel(String n){
		int i = n.lastIndexOf(">") + 1;
		String stripped = n.substring(i, n.length());
		String title = stripped.substring(stripped.indexOf(stripped.charAt(0)),stripped.indexOf(elapsed));
		title = title.trim();
		return title;
	}
	public static void checkDuplicate(LinkedList<String> label, String title, String a, String b){
		if(title.equals(a)){
			if(label.contains(a)){
				title += " ";
			}
		}else if(title.equals(b)){
			if(label.contains(b)){
				title += " ";
			}
		}
		label.add(title);		
	}

	public static void getFile(String filename) throws IOException{
		String title = "";
		String elapsedTime = "";
		String peakMem = "";
		String peakTitle = "";
		String date = "";
		String tempDate = "";
		String failure1item = "Failure of 1 items";
		String recovery1item = "Recovery of 1 items";
		String [] allLabels = {"Mesh Delay Analysis of 1 items", "Failure of 1 items", "Recovery of 1 items", "Failure of 20 items", "Recovery of 20 items",
				"Failure of 1 items ", "Recovery of 1 items ", "Failure of 50 items", "Recovery of 50 items", "Routing simulation of 11276 SONET_SDH_SNC",
				"Deleting SNCs Total Count 11276", "Routing simulation of 842 SONET_SDH_SNCP", "Deleting SNCPs Total Count 845", "Deleting DSHSNCs Total Count 953",
				"AFA-Nodes", "AFA-Lines", "AFA-Bundles", "AFA-LMs", "Mesh Survivabiity Assistant", "Mesh Delay Analysis of 5 items", "Mesh Delay Analysis of 125 items",
				"Mesh Delay Analysis of 25 items", "ADA-Nodes", "ADA-Lines", "ADA-Bundles", "ADA-LMs"};
		boolean [] hasTime = new boolean [allLabels.length + 1];
		boolean [] peakTime = new boolean [allLabels.length+1];
		boolean [] largeValues = new boolean[allLabels.length+1];
		LinkedList<String>label = new LinkedList<String>();
		LinkedList<String>peakLabel = new LinkedList<String>();
		final DefaultCategoryDataset dt = new DefaultCategoryDataset();
		final DefaultCategoryDataset dtLarge = new DefaultCategoryDataset();
		final DefaultCategoryDataset peakdt = new DefaultCategoryDataset();
		final DefaultCategoryDataset lineChart = new DefaultCategoryDataset();
		final DefaultCategoryDataset peaklineChart = new DefaultCategoryDataset();
		final DefaultPieDataset piedt = new DefaultPieDataset();
		try{
			@SuppressWarnings("resource")
			Scanner file = new Scanner(new File(filename));
			while(file.hasNext()){
				String checkWord = file.nextLine();
				tempDate = date;
				date = getDate(checkWord);  //most current
				if(!date.equals(tempDate) && !tempDate.equals("")){
					System.out.println("\n\n========="+date+"=========");
					while(!label.isEmpty()){
						label.remove(0);
					}
					while(!peakLabel.isEmpty()){
						peakLabel.remove(0);
					}
				}
				int aIndex = checkWord.lastIndexOf(">") + 1;
				String stripped = checkWord.substring(aIndex, checkWord.length());
				if(stripped.contains(elapsed) || stripped.contains(peak)){
					if(stripped.contains(elapsed)){
						title = stripped.substring(stripped.indexOf(stripped.charAt(0)),stripped.indexOf(elapsed));
						title = title.trim();
						if(title.equals(failure1item)){
							if(label.contains(failure1item)){
								title += " ";
							}
						}else if(title.equals(recovery1item)){
							if(label.contains(recovery1item)){
								title += " ";
							}
						}
						label.add(title);	
						String rmove = removeNonTime(stripped);
						elapsedTime = rmove.substring(rmove.indexOf("0"), rmove.indexOf("."));
						System.out.print(title+"  "+elapsedTime+"\n");
						elapsedTime = elapsedTime.replaceAll(":", ".");
						elapsedTime = elapsedTime.replaceFirst("[.]", "");
						double eTime = Double.parseDouble(elapsedTime);
						if(Arrays.asList(allLabels).contains(title)){
							int titleIndex = searchTitle(allLabels, title);
							if(!(eTime > 5)){
							dt.addValue(eTime, date, allLabels[titleIndex]);
							lineChart.addValue(eTime, date, allLabels[titleIndex]);
							piedt.setValue(allLabels[titleIndex], eTime);
							hasTime[titleIndex] = true;
							}else{
								dtLarge.addValue(eTime, date, allLabels[titleIndex]);
								largeValues[titleIndex] = true;
							}
						}																		
					}
					else if(stripped.contains(peak)){
						peakMem = stripped.substring(stripped.lastIndexOf(")")+1);
						peakMem = peakMem.replaceAll("\\s", "");
						long pMem = Long.parseLong(peakMem);
						peakTitle = stripped.substring(stripped.indexOf(stripped.charAt(0)),stripped.indexOf(peak));
						peakTitle = peakTitle.trim();
						if(peakTitle.equals(failure1item)){
							if(peakLabel.contains(failure1item)){
								peakTitle += " ";
							}
						}else if(peakTitle.equals(recovery1item)){
							if(peakLabel.contains(recovery1item)){
								peakTitle += " ";
							}
						}
						peakLabel.add(peakTitle);					
						if(Arrays.asList(allLabels).contains(peakTitle)){
							int titleIndex = searchTitle(allLabels, peakTitle);
							peakdt.addValue(pMem, date, allLabels[titleIndex]);
							peaklineChart.addValue(pMem, date, allLabels[titleIndex]);
							peakTime[titleIndex] = true;
						}
					}						
				}					

			}
		}catch(FileNotFoundException e){
			System.out.println("File name does not exist, check path ?");
			System.exit(0);
		}
		JFreeChart pieChart = ChartFactory.createPieChart("Elapsed Time", piedt, true, true, false);
		createBarChart(dt, hasTime, allLabels, "OnePChart.jpeg");
		createPeakBarChart(peakdt, peakTime, allLabels, "PeakChart.jpeg");
		createBarChart(dtLarge, largeValues, allLabels, "LargeValues.jpeg");
		createLineGraph(lineChart, hasTime, allLabels, "TimeGraph.jpeg");
		createPeakLineGraph(peaklineChart, peakTime, allLabels, "PeakLineGraph.jpeg");
		File apieChart = new File("PieChart.jpeg");
		ChartUtilities.saveChartAsJPEG(apieChart, pieChart, width, height);
	}
	
	public static void createPeakBarChart(DefaultCategoryDataset dataset,boolean [] isFilled, String [] label, String filename) throws IOException{
		for(int i = 0; i < label.length; i++){
			if(!isFilled[i]){
				dataset.addValue(0, " ", label[i]);
			}
		}
		JFreeChart barChart = ChartFactory.createBarChart("Automated Result", "Peak Virtual Mem Size", "Test Variable", dataset, PlotOrientation.HORIZONTAL, true, true, false);
		File BarChart = new File("C:\\Users\\"+Username+"\\Desktop\\OnePCharts\\"+filename);
		ChartUtilities.saveChartAsJPEG(BarChart, barChart, width, height);		
	}

	public static void createBarChart(DefaultCategoryDataset dataset,boolean [] isFilled, String [] label, String filename) throws IOException{
		for(int i = 0; i < label.length; i++){
			if(!isFilled[i]){
				dataset.addValue(0, " ", label[i]);
			}
		}
		JFreeChart barChart = ChartFactory.createBarChart("Automated Result", "Elapsed Time", "Test Variable", dataset, PlotOrientation.HORIZONTAL, true, true, false);
		File BarChart = new File("C:\\Users\\"+Username+"\\Desktop\\OnePCharts\\"+filename);
		ChartUtilities.saveChartAsJPEG(BarChart, barChart, width, height);		
	}

	public static void createLineGraph(DefaultCategoryDataset lineChart, boolean [] isFilled, String [] label, String filename) throws IOException{
		for(int i = 0; i < label.length; i++){
			if(!isFilled[i]){
				lineChart.addValue(0, " ", label[i]);
			}
		}
		JFreeChart tChart = ChartFactory.createLineChart("Automated Test", "Elapsed Time", "Test Variable", lineChart, PlotOrientation.HORIZONTAL,true , false, false);
		File timeChart = new File("C:\\Users\\"+Username+"\\Desktop\\OnePCharts\\"+filename);
		ChartUtilities.saveChartAsJPEG(timeChart, tChart, width, height);
	}
	
	public static void createPeakLineGraph(DefaultCategoryDataset lineChart, boolean [] isFilled, String [] label, String filename) throws IOException{
		for(int i = 0; i < label.length; i++){
			if(!isFilled[i]){
				lineChart.addValue(0, " ", label[i]);
			}
		}
		JFreeChart tChart = ChartFactory.createLineChart("Automated Test", "Peak Virtual Mem Size", "Test Variable", lineChart, PlotOrientation.HORIZONTAL,true , false, false);
		File timeChart = new File("C:\\Users\\"+Username+"\\Desktop\\OnePCharts\\"+filename);
		ChartUtilities.saveChartAsJPEG(timeChart, tChart, width, height);
	}
	public Graph(){
		submit = new JButton("Submit");
		username = new JTextField(10);
		OnepVersion = new JTextField(10);
		lblUsername = new JLabel("Username");
		lblVersion = new JLabel("Version");
		writeToExcel = new JRadioButton("Write to Excel");
		submit.addActionListener((e) -> {
			submitAction();
		});
		setLayout(new FlowLayout());
		add(lblUsername);
		add(username);
		add(lblVersion);
		add(OnepVersion);
		add(writeToExcel);
		add(submit);
	}

	private void submitAction(){
		Username = username.getText();
		version = OnepVersion.getText();
		String path = "C:\\Users\\"+Username+"\\AppData\\Roaming\\Ciena\\OnePlanner "+version+"\\Logs";
		String fileType = "OnePlanner";
		String file = searchLast(fileType, path);
		try {
			getFile(path+"\\"+file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	public void createShowUI(){
		JFrame f = new JFrame("Oneplanner Automation");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new Graph());
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		new Graph().createShowUI();
	}
}