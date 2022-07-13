package br.com.mind5.file.fileImageDecorated.model.action;

import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.file.fileImageDecorated.info.FimecoSetterMatKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimecoVisiEnforceMatKey extends ActionVisitorTemplateEnforce<FimecoInfo> {
	
	public FimecoVisiEnforceMatKey(DeciTreeOption<FimecoInfo> option) {
		super(option);
	}

	
	
	@Override protected FimecoInfo enforceHook(FimecoInfo recordInfo) {
		InfoSetter<FimecoInfo> attrSetter = new FimecoSetterMatKey();
		return attrSetter.setAttr(recordInfo);
	}
	
	
	
	@Override protected boolean shouldUniquifyResult() {
		return super.UNIQUIFY_RESULTS;
	}
}
