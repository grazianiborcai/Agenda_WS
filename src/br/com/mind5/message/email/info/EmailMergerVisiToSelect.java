package br.com.mind5.message.email.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmailMergerVisiToSelect extends InfoMergerVisitorTemplate<EmailInfo, EmailInfo> {

	@Override public boolean shouldMerge(EmailInfo baseInfo, EmailInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<EmailInfo> merge(EmailInfo baseInfo, EmailInfo selectedInfo) {
		List<EmailInfo> results = new ArrayList<>();
		
		baseInfo.senderAddr = selectedInfo.senderAddr;
		baseInfo.senderPass = selectedInfo.senderPass;		
		baseInfo.smtpHostname = selectedInfo.smtpHostname;
		baseInfo.smtpPort = selectedInfo.smtpPort;
		
		results.add(baseInfo);
		return results;
	}
}
