package br.com.mind5.message.emailBody.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmabodyVisiMergeToSelect implements InfoMergerVisitor<EmabodyInfo, EmabodyInfo> {
	
	@Override public List<EmabodyInfo> beforeMerge(List<EmabodyInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<EmabodyInfo> getUniquifier() {
		return null;
	}
}
