package com.elixer.paws.di

import com.elixer.paws.interactors.dog_list.GetDogs
import com.elixer.paws.network.RetrofitService
import com.elixer.paws.network.model.DogDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object InteractorsModule {

    @ViewModelScoped
    @Provides
    fun provideGetDogs(retrofitService: RetrofitService, dtoMapper: DogDtoMapper) =
        GetDogs(retrofitService, dtoMapper)
//
//  @ViewModelScoped
//  @Provides
//  fun provideRestoreRecipes(
//    recipeDao: RecipeDao,
//    recipeEntityMapper: RecipeEntityMapper,
//  ): RestoreRecipes {
//    return RestoreRecipes(
//      recipeDao = recipeDao,
//      entityMapper = recipeEntityMapper,
//    )
//  }
//
//  @ViewModelScoped
//  @Provides
//  fun provideGetRecipe(
//    recipeDao: RecipeDao,
//    recipeEntityMapper: RecipeEntityMapper,
//    recipeService: RecipeService,
//    recipeDtoMapper: RecipeDtoMapper,
//  ): GetRecipe {
//    return GetRecipe(
//      recipeDao = recipeDao,
//      entityMapper = recipeEntityMapper,
//      recipeService = recipeService,
//      recipeDtoMapper = recipeDtoMapper,
//    )
//  }

}











