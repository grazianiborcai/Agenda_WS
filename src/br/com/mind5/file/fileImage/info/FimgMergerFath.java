package br.com.mind5.file.fileImage.info;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class FimgMergerFath extends InfoMergerTemplate<FimgInfo, FathInfo> {

	@Override protected InfoMergerVisitor<FimgInfo, FathInfo> getVisitorHook() {
		return new FimgVisiMergeFath();
	}
	
	
	
	@Override protected InfoUniquifier<FimgInfo> getUniquifierHook() {
		return new FimgUniquifier();
	}
}
