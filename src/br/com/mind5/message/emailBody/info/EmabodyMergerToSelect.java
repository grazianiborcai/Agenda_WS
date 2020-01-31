package br.com.mind5.message.emailBody.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmabodyMergerToSelect extends InfoMergerTemplate_<EmabodyInfo, EmabodyInfo> {

	@Override protected InfoMergerVisitor_<EmabodyInfo, EmabodyInfo> getVisitorHook() {
		return new EmabodyVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmabodyInfo> getUniquifierHook() {
		return new EmabodyUniquifier();
	}
}
