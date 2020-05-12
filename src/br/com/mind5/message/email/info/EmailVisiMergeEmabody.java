package br.com.mind5.message.email.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

final class EmailVisiMergeEmabody implements InfoMergerVisitorV3<EmailInfo, EmabodyInfo> {
	
	@Override public List<EmailInfo> beforeMerge(List<EmailInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmailInfo baseInfo, EmabodyInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<EmailInfo> merge(EmailInfo baseInfo, EmabodyInfo selectedInfo) {
		List<EmailInfo> results = new ArrayList<>();
		
		baseInfo.bodyData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmailInfo> getUniquifier() {
		return null;
	}
}
