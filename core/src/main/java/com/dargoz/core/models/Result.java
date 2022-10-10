package com.dargoz.core.models;

import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {

    private UiState state;
    private String statusMessage;
    private T data;

    public final <R> Result<R> map(Function<? super T, ? extends R> mapper) throws Exception {
        ObjectHelper.requireNonNull(mapper, "mapper is null");
        return new Result<>(this.state, this.statusMessage, mapper.apply(this.data));
    }

}
