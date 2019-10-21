package br.com.mind5.message.email.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

public final class EmailMerger {
	public static EmailInfo mergeWithEmabody(EmabodyInfo sourceOne, EmailInfo sourceTwo) {
		InfoMerger<EmailInfo, EmabodyInfo> merger = new EmailMergerEmabody();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmailInfo> mergeWithEmabody(List<EmabodyInfo> sourceOnes, List<EmailInfo> sourceTwos) {
		InfoMerger<EmailInfo, EmabodyInfo> merger = new EmailMergerEmabody();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmailInfo mergeToSelect(EmailInfo sourceOne, EmailInfo sourceTwo) {
		InfoMerger<EmailInfo, EmailInfo> merger = new EmailMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmailInfo> mergeToSelect(List<EmailInfo> sourceOnes, List<EmailInfo> sourceTwos) {
		InfoMerger<EmailInfo, EmailInfo> merger = new EmailMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
