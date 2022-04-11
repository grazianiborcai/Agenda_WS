package br.com.mind5.business.orderSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSearch.model.action.OrdarchVisiMergeToSelect;
import br.com.mind5.business.orderSearch.model.checker.OrdarchCheckLangu;
import br.com.mind5.business.orderSearch.model.checker.OrdarchCheckOwner;
import br.com.mind5.business.orderSearch.model.checker.OrdarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class OrdarchRootSelect extends DeciTreeTemplateRead<OrdarchInfo> {
	
	public OrdarchRootSelect(DeciTreeOption<OrdarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdarchInfo> buildCheckerHook(DeciTreeOption<OrdarchInfo> option) {
		List<ModelChecker<OrdarchInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrdarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdarchCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdarchCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdarchInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdarchInfo> option) {
		List<ActionStd<OrdarchInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrdarchInfo> select = new ActionStdCommom<OrdarchInfo>(option, OrdarchVisiMergeToSelect.class);
		
		actions.add(select);			
		return actions;
	}
}
