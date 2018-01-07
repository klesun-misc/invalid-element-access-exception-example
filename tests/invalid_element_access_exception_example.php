<?php

// if you put caret inside quotes ('') in the first function and hit ctrl+space,
// then inside quotes in the second function, then again in the first function,
// you will get this exception in present version of phpstorm, 2017.3.2:
//
// 2018-01-07 02:47:42,618 [ 154754]  ERROR - on.CompletionProgressIndicator - Element: class com.jetbrains.php.lang.psi.elements.impl.VariableImpl because: containing file is null
// invalidated at: see attachment
// com.intellij.psi.PsiInvalidElementAccessException: Element: class com.jetbrains.php.lang.psi.elements.impl.VariableImpl because: containing file is null
// invalidated at: see attachment
//     at com.intellij.psi.util.PsiUtilCore.ensureValid(PsiUtilCore.java:502)
//     at com.intellij.psi.impl.source.resolve.ResolveCache.ensureValidPsi(ResolveCache.java:217)
//     at com.intellij.psi.impl.source.resolve.ResolveCache.ensureValidResults(ResolveCache.java:210)
//     at com.intellij.psi.impl.source.resolve.ResolveCache.resolve(ResolveCache.java:150)
//     at com.intellij.psi.impl.source.resolve.ResolveCache.resolveWithCaching(ResolveCache.java:175)
//     at com.intellij.psi.impl.source.resolve.ResolveCache.resolveWithCaching(ResolveCache.java:167)
//     at com.jetbrains.php.lang.psi.elements.impl.VariableImpl.multiResolve(VariableImpl.java:342)
//     at com.jetbrains.php.lang.psi.elements.impl.VariableImpl.resolve(VariableImpl.java:301)
//     at org.klesun.deep_assoc_completion.completion_providers.DeepKeysPvdr.addCompletions(DeepKeysPvdr.java:35)

function providePdoSqlSelectMultiTable($params)
{
    $result = asd();
    $result[''];
}

function providePdoSqlSelectConcatSql($params)
{
    $result = asd();
    $result[''];
}