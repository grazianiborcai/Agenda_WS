package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.MatVisiNodeSytotauh;
import br.com.mind5.business.material.model.action.MatVisiMergeFimeco;
import br.com.mind5.business.material.model.action.MatVisiMergeMateg;
import br.com.mind5.business.material.model.action.MatVisiMergeMatext;
import br.com.mind5.business.material.model.action.MatVisiMergeMatoup;
import br.com.mind5.business.material.model.action.MatVisiMergeMatubup;
import br.com.mind5.business.material.model.action.MatVisiMergeMatunit;
import br.com.mind5.business.material.model.action.MatVisiMergeMatype;
import br.com.mind5.business.material.model.action.MatVisiMergeToSelect;
import br.com.mind5.business.material.model.checker.MatCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MatRootSelect extends DeciTreeTemplateRead<MatInfo> {
	
	public MatRootSelect(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatInfo> buildCheckerHook(DeciTreeOption<MatInfo> option) {
		List<ModelChecker<MatInfo>> queue = new ArrayList<>();		
		ModelChecker<MatInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStd<MatInfo>> actions = new ArrayList<>();
		
		ActionStd<MatInfo> select = new ActionStdCommom<MatInfo>(option, MatVisiMergeToSelect.class);
		ActionLazy<MatInfo> nodeSytotauh = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiNodeSytotauh.class);
		ActionLazy<MatInfo> mergeMatype = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiMergeMatype.class);
		ActionLazy<MatInfo> mergeMateg = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiMergeMateg.class);
		ActionLazy<MatInfo> mergeMatoup = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiMergeMatoup.class);
		ActionLazy<MatInfo> mergeMatubup = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiMergeMatubup.class);
		ActionLazy<MatInfo> mergeMatunit = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiMergeMatunit.class);
		ActionLazy<MatInfo> mergeMatext = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiMergeMatext.class);
		ActionLazy<MatInfo> mergeFimeco = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiMergeFimeco.class);
		
		select.addPostAction(nodeSytotauh);
		nodeSytotauh.addPostAction(mergeMatype);
		mergeMatype.addPostAction(mergeMateg);
		mergeMateg.addPostAction(mergeMatoup);
		mergeMatoup.addPostAction(mergeMatubup);		
		mergeMatubup.addPostAction(mergeMatunit);
		mergeMatunit.addPostAction(mergeMatext);
		mergeMatext.addPostAction(mergeFimeco);
		
		actions.add(select);
		return actions;
	}
}
