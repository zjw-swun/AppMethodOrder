import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TraceScanner {
	private File file;
	private String packageName = Config.PACKAGE_NAME;
	private AnalysisListener listener;

	public TraceScanner(File file) {
		super();
		this.file = file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public void setListener(AnalysisListener listener) {
		this.listener = listener;
	}

	public ArrayList<String> convertFile(String path) {
		ArrayList<String> index = new ArrayList<String>();
		String cmd = "dmtracedump -o " + path;
		index.add("PackageName: " + packageName + "\n");
		index.add("start dmtracedump\n");
		String oName = packageName.replaceAll("[.]", "/");
		if (listener != null) {
			listener.startAnalysis();
		}
		if (!file.exists()) {
			System.out.println("File does not exist");
		} else {

			Runtime runtime = Runtime.getRuntime();
			BufferedReader br = null;
			try {
				Process p = Runtime.getRuntime().exec(cmd);
				br = new BufferedReader(new InputStreamReader(
						p.getInputStream()));
				String lineTxt = null;
				while ((lineTxt = br.readLine()) != null) {
					if (lineTxt.contains(" ent ")
							&& (lineTxt.contains(packageName) || lineTxt
									.contains(oName))) {
						System.out.println(lineTxt);
						index.add(lineTxt + "\n");
					}
				}
			} catch (Exception e) {
				index.add("ִ执行dmtracedump命令异常\n");
				e.printStackTrace();
			} finally {

				if (br != null) {
					try {
						br.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				index.add("end dmtracedump\n");
				System.out.println("cmd end");
				if (listener != null) {
					listener.afterAnalysis();
				}
			}
		}
		return index;

	}

	public interface AnalysisListener {
		void startAnalysis();

		void afterAnalysis();
	}

}
