package br.com.mind5.message.emailWelcome.info;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmacomeMergerOwnelis extends InfoMergerTemplate<EmacomeInfo, OwnelisInfo> {

	@Override protected InfoMergerVisitor<EmacomeInfo,  OwnelisInfo> getVisitorHook() {
		return new EmacomeVisiMergeOwnelis();
	}
	
	
	
	@Override protected InfoUniquifier<EmacomeInfo> getUniquifierHook() {
		return new EmacomeUniquifier();
	}
}
