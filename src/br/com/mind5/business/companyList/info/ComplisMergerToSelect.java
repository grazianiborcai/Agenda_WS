package br.com.mind5.business.companyList.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;

final class ComplisMergerToSelect extends InfoMergerTemplate<ComplisInfo, ComplisInfo> {

	@Override protected InfoMergerVisitor<ComplisInfo, ComplisInfo> getVisitorHook() {
		return new ComplisVisiMergeToSelect();
	}
}
