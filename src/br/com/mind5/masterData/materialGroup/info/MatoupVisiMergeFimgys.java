package br.com.mind5.masterData.materialGroup.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatoupVisiMergeFimgys extends InfoMergerVisitorTemplate<MatoupInfo, FimgysInfo> {

	@Override public boolean shouldMerge(MatoupInfo baseInfo, FimgysInfo selectedInfo) {
		return (baseInfo.codGroup == selectedInfo.codGroup);
	}
	
	
	
	@Override public List<MatoupInfo> merge(MatoupInfo baseInfo, FimgysInfo selectedInfo) {
		List<MatoupInfo> results = new ArrayList<>();
		
		baseInfo.fimgysData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
