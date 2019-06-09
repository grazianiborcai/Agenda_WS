package br.com.gda.message.email.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

public final class EmailMerger {
	public static EmailInfo mergeToSelect(EmailInfo sourceOne, EmailInfo sourceTwo) {
		InfoMerger<EmailInfo, EmailInfo> merger = new EmailMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmailInfo> mergeToSelect(List<EmailInfo> sourceOnes, List<EmailInfo> sourceTwos) {
		InfoMerger<EmailInfo, EmailInfo> merger = new EmailMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
