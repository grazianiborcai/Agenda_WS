package br.com.mind5.payment.marketplacePartnerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.marketplacePartnerSearch.info.MktpararchInfo;
import br.com.mind5.payment.marketplacePartnerSearch.model.action.MktpararchVisiDaoSelect;
import br.com.mind5.payment.marketplacePartnerSearch.model.checker.MktpararchCheckRead;

public final class MktpararchRootSelect extends DeciTreeTemplateRead<MktpararchInfo> {
	
	public MktpararchRootSelect(DeciTreeOption<MktpararchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MktpararchInfo> buildCheckerHook(DeciTreeOption<MktpararchInfo> option) {
		List<ModelChecker<MktpararchInfo>> queue = new ArrayList<>();		
		ModelChecker<MktpararchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MktpararchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MktpararchInfo>> buildActionsOnPassedHook(DeciTreeOption<MktpararchInfo> option) {
		List<ActionStd<MktpararchInfo>> actions = new ArrayList<>();
		
		ActionStd<MktpararchInfo> select = new ActionStdCommom<MktpararchInfo>(option, MktpararchVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
