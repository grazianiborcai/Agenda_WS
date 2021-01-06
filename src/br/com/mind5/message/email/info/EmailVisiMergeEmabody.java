package br.com.mind5.message.email.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

final class EmailVisiMergeEmabody extends InfoMergerVisitorTemplate<EmailInfo, EmabodyInfo> {

	@Override public boolean shouldMerge(EmailInfo baseInfo, EmabodyInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<EmailInfo> merge(EmailInfo baseInfo, EmabodyInfo selectedInfo) {
		List<EmailInfo> results = new ArrayList<>();
		
		baseInfo.bodyData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
