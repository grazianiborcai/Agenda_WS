package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.LazyMatMergeFimist;
import br.com.mind5.business.material.model.action.LazyMatMergeMateg;
import br.com.mind5.business.material.model.action.LazyMatMergeMatext;
import br.com.mind5.business.material.model.action.LazyMatMergeMatoup;
import br.com.mind5.business.material.model.action.LazyMatMergeMatubup;
import br.com.mind5.business.material.model.action.LazyMatMergeMatunit;
import br.com.mind5.business.material.model.action.LazyMatMergeMatype;
import br.com.mind5.business.material.model.action.LazyMatNodeSytotauh;
import br.com.mind5.business.material.model.action.StdMatMergeToSelect;
import br.com.mind5.business.material.model.checker.MatCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootMatSelect extends DeciTreeTemplateReadV2<MatInfo> {
	
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
	
	
	
	@Override protected List<ActionStdV2<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStdV2<MatInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MatInfo> select = new StdMatMergeToSelect(option);
		ActionLazy<MatInfo> nodeSytotauh = new LazyMatNodeSytotauh(option.conn, option.schemaName);
		ActionLazy<MatInfo> mergeMatype = new LazyMatMergeMatype(option.conn, option.schemaName);
		ActionLazy<MatInfo> mergeMateg = new LazyMatMergeMateg(option.conn, option.schemaName);
		ActionLazy<MatInfo> mergeMatoup = new LazyMatMergeMatoup(option.conn, option.schemaName);
		ActionLazy<MatInfo> mergeMatubup = new LazyMatMergeMatubup(option.conn, option.schemaName);
		ActionLazy<MatInfo> mergeMatunit = new LazyMatMergeMatunit(option.conn, option.schemaName);
		ActionLazy<MatInfo> mergeMatext = new LazyMatMergeMatext(option.conn, option.schemaName);
		ActionLazy<MatInfo> mergeFimist = new LazyMatMergeFimist(option.conn, option.schemaName);
		
		select.addPostAction(nodeSytotauh);
		nodeSytotauh.addPostAction(mergeMatype);
		mergeMatype.addPostAction(mergeMateg);
		mergeMateg.addPostAction(mergeMatoup);
		mergeMatoup.addPostAction(mergeMatubup);		
		mergeMatubup.addPostAction(mergeMatunit);
		mergeMatunit.addPostAction(mergeMatext);
		mergeMatext.addPostAction(mergeFimist);
		
		actions.add(select);
		return actions;
	}
}
