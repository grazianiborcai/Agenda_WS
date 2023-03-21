package br.com.mind5.business.orderStatusChange.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.business.orderStatusChange.model.action.OrdugeVisiEnforcePagarme;
import br.com.mind5.business.orderStatusChange.model.checker.OrdugeCheckIsPagarme;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class OrdugeNodePartnerL2 extends DeciTreeTemplateRead<OrdugeInfo> {
	
	public OrdugeNodePartnerL2(DeciTreeOption<OrdugeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdugeInfo> buildCheckerHook(DeciTreeOption<OrdugeInfo> option) {
		List<ModelChecker<OrdugeInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdugeInfo> checker;
		ModelCheckerOption checkerOption;

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrdugeCheckIsPagarme(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdugeInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdugeInfo> option) {
		List<ActionStd<OrdugeInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrdugeInfo> enforceStatus = new ActionStdCommom<OrdugeInfo>(option, OrdugeVisiEnforcePagarme.class);
		
		actions.add(enforceStatus);			
		return actions;
	}
}
