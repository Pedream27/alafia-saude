package br.dev.phsaraiva.alafiasaude.mapper;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ObjectMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return modelMapper.map(origin, destination);
    }

    public static <O, D> List<D> parseList(List<O> origin, Class<D> destination) {
        return origin.stream()
                .map(obj -> modelMapper.map(obj, destination))
                .collect(Collectors.toList());
    }
}
