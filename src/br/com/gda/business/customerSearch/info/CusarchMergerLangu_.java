package br.com.gda.business.customerSearch.info;

import java.util.List;

import br.com.gda.business.masterData.info.LanguInfo;
import br.com.gda.info.InfoMerger_;

final class CusarchMergerLangu_ extends InfoMerger_<CusarchInfo, LanguInfo, CusarchInfo> {
	public CusarchInfo merge(LanguInfo sourceOne, CusarchInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CusarchVisiMergeLangu_());
	}
	
	
	
	public List<CusarchInfo> merge(List<LanguInfo> sourceOnes, List<CusarchInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CusarchVisiMergeLangu_());
	}
}
