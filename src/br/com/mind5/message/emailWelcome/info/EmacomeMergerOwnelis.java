package br.com.mind5.message.emailWelcome.info;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmacomeMergerOwnelis extends InfoMergerTemplate_<EmacomeInfo, OwnelisInfo> {

	@Override protected InfoMergerVisitor_<EmacomeInfo,  OwnelisInfo> getVisitorHook() {
		return new EmacomeVisiMergeOwnelis();
	}
	
	
	
	@Override protected InfoUniquifier<EmacomeInfo> getUniquifierHook() {
		return new EmacomeUniquifier();
	}
}
