package br.dev.phsaraiva.alafiasaude.exception;

import java.util.Date;

public record ExcepitonResponse(Date timesTamp, String menssage , String datails) {
}
