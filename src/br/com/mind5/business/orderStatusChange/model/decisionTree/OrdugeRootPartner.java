package br.com.mind5.business.orderStatusChange.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.business.orderStatusChange.model.action.OrdugeVisiMergePayordist;
import br.com.mind5.business.orderStatusChange.model.action.OrdugeVisiNodePartnerL1;
import br.com.mind5.business.orderStatusChange.model.checker.OrdugeCheckPartner;
import br.com.mind5.business.orderStatusChange.model.checker.OrdugeCheckPayord;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class OrdugeRootPartner extends DeciTreeTemplateRead<OrdugeInfo> {
	
	public OrdugeRootPartner(DeciTreeOption<OrdugeInfo> option) {
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
		checker = new OrdugeCheckPartner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdugeCheckPayord(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdugeInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdugeInfo> option) {
		List<ActionStd<OrdugeInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrdugeInfo>  mergePayordist = new ActionStdCommom<OrdugeInfo> (option, OrdugeVisiMergePayordist.class);
		ActionLazy<OrdugeInfo> nodeL1         = new ActionLazyCommom<OrdugeInfo>(option, OrdugeVisiNodePartnerL1.class);

		mergePayordist.addPostAction(nodeL1);
		
		actions.add(mergePayordist);			
		return actions;
	}
}
