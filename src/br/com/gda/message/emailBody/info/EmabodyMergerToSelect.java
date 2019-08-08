package br.com.gda.message.emailBody.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class EmabodyMergerToSelect extends InfoMergerTemplate<EmabodyInfo, EmabodyInfo> {

	@Override protected InfoMergerVisitor<EmabodyInfo, EmabodyInfo> getVisitorHook() {
		return new EmabodyVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmabodyInfo> getUniquifierHook() {
		return new EmabodyUniquifier();
	}
}
