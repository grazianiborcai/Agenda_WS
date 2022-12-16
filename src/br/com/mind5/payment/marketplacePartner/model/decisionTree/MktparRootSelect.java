package br.com.mind5.payment.marketplacePartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.marketplacePartner.info.MktparInfo;
import br.com.mind5.payment.marketplacePartner.model.action.MktparVisiDaoSelect;
import br.com.mind5.payment.marketplacePartner.model.checker.MktparCheckRead;

public final class MktparRootSelect extends DeciTreeTemplateRead<MktparInfo> {
	
	public MktparRootSelect(DeciTreeOption<MktparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MktparInfo> buildCheckerHook(DeciTreeOption<MktparInfo> option) {
		List<ModelChecker<MktparInfo>> queue = new ArrayList<>();		
		ModelChecker<MktparInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MktparCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MktparInfo>> buildActionsOnPassedHook(DeciTreeOption<MktparInfo> option) {
		List<ActionStd<MktparInfo>> actions = new ArrayList<>();
		
		ActionStd<MktparInfo> select = new ActionStdCommom<MktparInfo>(option, MktparVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
