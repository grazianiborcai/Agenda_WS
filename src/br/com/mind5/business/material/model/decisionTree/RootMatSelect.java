package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.LazyMatMergeFimist;
import br.com.mind5.business.material.model.action.LazyMatMergeMatCateg;
import br.com.mind5.business.material.model.action.LazyMatMergeMatGroup;
import br.com.mind5.business.material.model.action.LazyMatMergeMatType;
import br.com.mind5.business.material.model.action.LazyMatMergeMatUnit;
import br.com.mind5.business.material.model.action.LazyMatMergeMatext;
import br.com.mind5.business.material.model.action.StdMatMergeToSelect;
import br.com.mind5.business.material.model.checker.MatCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootMatSelect extends DeciTreeTemplateReadV1<MatInfo> {
	
	public RootMatSelect(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatInfo> buildCheckerHook(DeciTreeOption<MatInfo> option) {
		List<ModelCheckerV1<MatInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStdV1<MatInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatInfo> select = new StdMatMergeToSelect(option);
		ActionLazyV1<MatInfo> mergeMatType = new LazyMatMergeMatType(option.conn, option.schemaName);
		ActionLazyV1<MatInfo> mergeMatCateg = new LazyMatMergeMatCateg(option.conn, option.schemaName);
		ActionLazyV1<MatInfo> mergeMatGroup = new LazyMatMergeMatGroup(option.conn, option.schemaName);
		ActionLazyV1<MatInfo> mergeMatUnit = new LazyMatMergeMatUnit(option.conn, option.schemaName);
		ActionLazyV1<MatInfo> mergeMatext = new LazyMatMergeMatext(option.conn, option.schemaName);
		ActionLazyV1<MatInfo> mergeFimist = new LazyMatMergeFimist(option.conn, option.schemaName);
		
		select.addPostAction(mergeMatType);
		mergeMatType.addPostAction(mergeMatCateg);
		mergeMatCateg.addPostAction(mergeMatGroup);
		mergeMatGroup.addPostAction(mergeMatUnit);
		mergeMatUnit.addPostAction(mergeMatext);
		mergeMatext.addPostAction(mergeFimist);
		
		actions.add(select);
		return actions;
	}
}
