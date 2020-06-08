package br.com.mind5.message.email.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class EmailVisiMergeToSelect implements InfoMergerVisitorV3<EmailInfo, EmailInfo> {
	
	@Override public List<EmailInfo> beforeMerge(List<EmailInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<EmailInfo> getUniquifier() {
		return null;
	}
}
