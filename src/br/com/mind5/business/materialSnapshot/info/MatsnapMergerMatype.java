package br.com.mind5.business.materialSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.masterData.materialType.info.MatypeInfo;

final class MatsnapMergerMatype extends InfoMergerTemplate_<MatsnapInfo, MatypeInfo> {

	@Override protected InfoMergerVisitor_<MatsnapInfo, MatypeInfo> getVisitorHook() {
		return new MatsnapVisiMergeMatype();
	}
	
	
	
	@Override protected InfoUniquifier<MatsnapInfo> getUniquifierHook() {
		return new MatsnapUniquifier();
	}
}
