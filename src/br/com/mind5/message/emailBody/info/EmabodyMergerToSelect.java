package br.com.mind5.message.emailBody.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmabodyMergerToSelect extends InfoMergerTemplate<EmabodyInfo, EmabodyInfo> {

	@Override protected InfoMergerVisitor<EmabodyInfo, EmabodyInfo> getVisitorHook() {
		return new EmabodyVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmabodyInfo> getUniquifierHook() {
		return new EmabodyUniquifier();
	}
}
