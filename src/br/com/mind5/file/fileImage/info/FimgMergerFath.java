package br.com.mind5.file.fileImage.info;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class FimgMergerFath extends InfoMergerTemplate_<FimgInfo, FathInfo> {

	@Override protected InfoMergerVisitor_<FimgInfo, FathInfo> getVisitorHook() {
		return new FimgVisiMergeFath();
	}
	
	
	
	@Override protected InfoUniquifier<FimgInfo> getUniquifierHook() {
		return new FimgUniquifier();
	}
}
