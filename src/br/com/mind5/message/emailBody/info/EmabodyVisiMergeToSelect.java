package br.com.mind5.message.emailBody.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmabodyVisiMergeToSelect extends InfoMergerVisitorTemplate<EmabodyInfo, EmabodyInfo> {

	@Override public boolean shouldMerge(EmabodyInfo baseInfo, EmabodyInfo selectedInfo) {
		return (baseInfo.codBody.equals(selectedInfo.codBody));
	}
	
	
	
	@Override public List<EmabodyInfo> merge(EmabodyInfo baseInfo, EmabodyInfo selectedInfo) {
		List<EmabodyInfo> results = new ArrayList<>();		
		
		baseInfo.txtbody = selectedInfo.txtbody;
		baseInfo.subject = selectedInfo.subject;
		
		results.add(baseInfo);
		return results;
	}
}
