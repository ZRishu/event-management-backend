package org.zr.tickets.controllers

import jakarta.validation.ConstraintViolationException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.zr.tickets.domain.dtos.ErrorDto
import org.zr.tickets.exceptions.EventNotFoundException
import org.zr.tickets.exceptions.EventUpdateException
import org.zr.tickets.exceptions.TicketTypeNotFoundException
import org.zr.tickets.exceptions.UserNotFoundException

@RestControllerAdvice
class GlobalExceptionHandler {

    private val log = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ExceptionHandler(EventUpdateException::class)
    fun handleEventUpdateException(ex: EventUpdateException): ResponseEntity<ErrorDto> {
        log.error("Caught EventUpdateException", ex)
        val errorDto = ErrorDto(error = "Unable to update event")
        return ResponseEntity(errorDto, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(TicketTypeNotFoundException::class)
    fun handleTicketTypeNotFoundException(ex: TicketTypeNotFoundException): ResponseEntity<ErrorDto> {
        log.error("Caught TicketTypeNotFoundException", ex)
        val errorDto = ErrorDto(error = "Ticket type not found")
        return ResponseEntity(errorDto, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(EventNotFoundException::class)
    fun handleEventNotFoundException(ex: EventNotFoundException): ResponseEntity<ErrorDto> {
        log.error("Caught EventNotFoundException", ex)
        val errorDto = ErrorDto(error = "Event not found")
        return ResponseEntity(errorDto, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFoundException(ex: UserNotFoundException): ResponseEntity<ErrorDto> {
        log.error("Caught UserNotFoundException", ex)
        val errorDto = ErrorDto(error = "User not found")
        return ResponseEntity(errorDto, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException): ResponseEntity<ErrorDto> {
        log.error("Caught MethodArgumentNotValidException", ex)

        val bindingResult = ex.bindingResult
        val errorMessage = (bindingResult.fieldErrors
            .firstOrNull()
            ?.let { "${it.field} : ${it.defaultMessage}" }
            ?: "Validation error occurred")

        val errorDto = ErrorDto(error = errorMessage)
        return ResponseEntity(errorDto, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolation(ex: ConstraintViolationException): ResponseEntity<ErrorDto> {
        log.error("Caught ConstraintViolationException", ex)

        val errorMessage = (ex.constraintViolations
            .firstOrNull()
            ?.let { "${it.propertyPath} : ${it.message}" }
            ?: "Constraint violation occurred")

        val errorDto = ErrorDto(error = errorMessage)
        return ResponseEntity(errorDto, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): ResponseEntity<ErrorDto> {
        log.error("Caught Exception", ex)
        val errorDto = ErrorDto(error = "An unknown error occurred")
        return ResponseEntity(errorDto, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}