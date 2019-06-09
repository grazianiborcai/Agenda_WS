package br.com.gda.message.emailBody.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmabodyMergerToSelect extends InfoMergerTemplate<EmabodyInfo, EmabodyInfo> {

	@Override protected InfoMergerVisitorV2<EmabodyInfo, EmabodyInfo> getVisitorHook() {
		return new EmabodyVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmabodyInfo> getUniquifierHook() {
		return new EmabodyUniquifier();
	}
}
