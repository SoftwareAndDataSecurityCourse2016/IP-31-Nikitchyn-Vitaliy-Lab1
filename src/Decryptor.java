import java.util.Map;

public abstract class Decryptor {		
	private Map<String, Float> monogramStandard;
	private Map<String, Float> bigramStandard;
	private Map<String, Float> trigramStandard;
	private Map<String, Float> quadgramStandard;
	
	public Decryptor() {		
		this.monogramStandard = FileWorker.loadStandard(1);
		this.bigramStandard = FileWorker.loadStandard(2);
		this.trigramStandard = FileWorker.loadStandard(3);
		this.quadgramStandard = FileWorker.loadStandard(4);
	}
	
	protected abstract String decrypt();
	protected abstract void printKey();
	
	protected String decrypt(String encryptedText, Map<String, String> currentKey) {
		String currDecriptedText = new String("");
		for (int i = 0; i < encryptedText.length(); i++) {
			currDecriptedText += currentKey.get(Character.toString(encryptedText.charAt(i)));
		}
		return currDecriptedText;
	}
	
	protected float computeQuality(String text, int n) {
		Map<String, Float> standard;
		switch (n) {
		case 1:
			standard = this.monogramStandard;
			break;
		case 2:
			standard = this.bigramStandard;
			break;
		case 3:
			standard = this.trigramStandard;
			break;
		case 4:
			standard = this.quadgramStandard;
			break;
		default:
			standard = null;
			break;
		}
					
		float currentQuality = 0f;
		for (int i = 0; i < text.length() - n + 1; i++) {						
			if (standard.containsKey(text.substring(i, i + n)))				
				currentQuality += standard.get(text.substring(i, i + n));			
		}				
		return currentQuality;
	}		
}
