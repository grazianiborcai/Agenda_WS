package br.com.gda.file.fileImage.info;

import br.com.gda.file.filePath.info.FathInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class FimgMergerFath extends InfoMergerTemplate<FimgInfo, FathInfo> {

	@Override protected InfoMergerVisitor<FimgInfo, FathInfo> getVisitorHook() {
		return new FimgVisiMergeFath();
	}
	
	
	
	@Override protected InfoUniquifier<FimgInfo> getUniquifierHook() {
		return new FimgUniquifier();
	}
}
