package br.com.gda.servlet.header;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.IOUtils;

public final class RequestWrapper extends HttpServletRequestWrapper {
	private ByteArrayOutputStream cachedBytes;

    public RequestWrapper(ServletRequest request) {
        this((HttpServletRequest)request);
    }
    
    
    
    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }
    
    
    
    @Override public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }
    
    
    
    @Override public ServletInputStream getInputStream() throws IOException {
        if (cachedBytes == null)
            cacheInputStream();

        return new CachedInputStream(cachedBytes);
    }  
    
    
    
    private void cacheInputStream() throws IOException {
        cachedBytes = new ByteArrayOutputStream();
        IOUtils.copy(super.getInputStream(), cachedBytes);
    }
    
    
    
    
    
    private class CachedInputStream extends ServletInputStream {
        private ByteArrayInputStream input;
        
        
        public CachedInputStream(ByteArrayOutputStream bytes) {
            input = new ByteArrayInputStream(bytes.toByteArray());
        }

        
        
        @Override public int read() throws IOException {
            return input.read();
        }
    }
}
